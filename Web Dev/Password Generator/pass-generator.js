function genPass(passLength, includeLowercase, includeUppercase, includeNumbers, includeSymbols) {
    const lowercaseChars = 'abcdefghijklmnopqrstuvwxyz';
    const uppercaseChars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    const nrChars = '0123456789';
    const symbolsChars = '!@#$%^&*()-_=+[{]};:\'",<.>/?\\|`~';
    let allowedChars = '';
    let password = '';
  
    allowedChars += includeLowercase ? lowercaseChars : '';
    allowedChars += includeUppercase ? uppercaseChars : '';
    allowedChars += includeNumbers ? nrChars : '';
    allowedChars += includeSymbols ? symbolsChars : '';
  
    if (passLength <= 3) {
      return '(Password length must be at least 3)';
    }
  
    if (allowedChars.length === 0) {
      return '(At least one set of characters needs to be selected)';
    }
  
    for (let i = 0; i < passLength; i++) {
      const randomIndex = Math.floor(Math.random() * allowedChars.length);
      password += allowedChars[randomIndex];
    }
  
    return password;
  }
  
  const passLength = 12;
  const includeLowercase = true;
  const includeUppercase = true;
  const includeNumbers = false;
  const includeSymbols = true;
  
  const password = genPass(passLength, includeLowercase, includeUppercase, includeNumbers, includeSymbols);
  
  console.log(`Generated password: ${password}`);
  