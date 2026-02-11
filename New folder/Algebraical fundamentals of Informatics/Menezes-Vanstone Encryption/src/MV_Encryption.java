
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPrivateKeySpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.util.PrivateKeyFactory;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.ECGenParameterSpec;
import java.util.Arrays;

public class MenezesVanstone {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static AsymmetricCipherKeyPair generateKeypair() throws Exception {
        ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256k1");
        KeyPairGenerator g = KeyPairGenerator.getInstance("ECDSA", "BC");
        g.initialize(ecSpec, new SecureRandom());
        KeyPair pair = g.generateKeyPair();

        ECPrivateKeySpec privateSpec = new ECPrivateKeySpec(pair.getPrivate().getEncoded(), ecSpec);
        ECPublicKeySpec publicSpec = new ECPublicKeySpec(pair.getPublic().getEncoded(), ecSpec);

        ECKeyPairGenerator gen = new ECKeyPairGenerator();
        ECKeyGenerationParameters keyGenParams = new ECKeyGenerationParameters(ecSpec, new SecureRandom());
        gen.init(keyGenParams);
        AsymmetricCipherKeyPair keyPair = gen.generateKeyPair();

        return keyPair;
    }

    public static byte[][] encrypt(CipherParameters publicKey, byte[] plaintext) throws Exception {
        ECKeyPairGenerator gen = new ECKeyPairGenerator();
        ECKeyGenerationParameters keyGenParams = new ECKeyGenerationParameters(((ECPublicKeyParameters) publicKey).getParameters(), new SecureRandom());
        gen.init(keyGenParams);
        AsymmetricCipherKeyPair ephemeralKeyPair = gen.generateKeyPair();

        ECPoint sharedSecretPoint = ((ECPublicKeyParameters) publicKey).getQ().multiply(((ECPrivateKeyParameters) ephemeralKeyPair.getPrivate()).getD());
        byte[] sharedSecret = hash(sharedSecretPoint.getXCoord().toBigInteger().toByteArray());

        PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()), new PKCS7Padding());
        cipher.init(true, new KeyParameter(Arrays.copyOf(sharedSecret, 16)));

        byte[] iv = new byte[cipher.getBlockSize()];
        new SecureRandom().nextBytes(iv);

        byte[] ciphertext = new byte[cipher.getOutputSize(plaintext.length)];
        int len = cipher.processBytes(plaintext, 0, plaintext.length, ciphertext, 0);
        cipher.doFinal(ciphertext, len);

        byte[] ephemeralPublicKey = ((ECPublicKeyParameters) ephemeralKeyPair.getPublic()).getQ().getEncoded(false);

        return new byte[][]{ephemeralPublicKey, iv, ciphertext};
    }

    public static byte[] decrypt(CipherParameters privateKey, byte[] ephemeralPublicKey, byte[] iv, byte[] ciphertext) throws Exception {
        ECPublicKeyParameters ephemeralPublicKeyParams = (ECPublicKeyParameters) PublicKeyFactory.createKey(ephemeralPublicKey);
        ECPoint sharedSecretPoint = ephemeralPublicKeyParams.getQ().multiply(((ECPrivateKeyParameters) privateKey).getD());
        byte[] sharedSecret = hash(sharedSecretPoint.getXCoord().toBigInteger().toByteArray());

        PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()), new PKCS7Padding());
        cipher.init(false, new KeyParameter(Arrays.copyOf(sharedSecret, 16)));

        byte[] plaintext = new byte[cipher.getOutputSize(ciphertext.length)];
        int len = cipher.processBytes(ciphertext, 0, ciphertext.length, plaintext, 0);
        cipher.doFinal(plaintext, len);

        return plaintext;
    }

    private static byte[] hash(byte[] input) {
        SHA256Digest digest = new SHA256Digest();
        byte[] hash = new byte[digest.getDigestSize()];
        digest.update(input, 0, input.length);
        digest.doFinal(hash, 0);
        return hash;
    }

    public static void main(String[] args) throws Exception {
        AsymmetricCipherKeyPair keyPair = generateKeypair();
        System.out.println("Private key: " + keyPair.getPrivate().toString());
        System.out.println("Public key: " + keyPair.getPublic().toString());

        String plaintext = "Hello, Menezes-Vanstone!";
        System.out.println("Plaintext: " + plaintext);

        byte[][] encrypted = encrypt(keyPair.getPublic(), plaintext.getBytes());
        System.out.println("Ephemeral Public Key: " + Arrays.toString(encrypted[0]));
        System.out.println("IV: " + Arrays.toString(encrypted[1]));
        System.out.println("Ciphertext: " + Arrays.toString(encrypted[2]));

        byte[] decrypted = decrypt(keyPair.getPrivate(), encrypted[0], encrypted[1], encrypted[2]);
        System.out.println("Decrypted Plaintext: " + new String(decrypted));
    }
}
