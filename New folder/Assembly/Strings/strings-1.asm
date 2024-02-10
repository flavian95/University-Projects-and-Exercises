section .data
    S1 db 'a', 'b', 'c', 'd'
    S1_len equ $ - S1

    S2 db 'e', 'f', 'g'
    S2_len equ $ - S2

    D db 255
    D_len equ $ - D

section .text
    global _start

_start:
    mov ecx, S1_len
    mov esi, S1
    mov edi, D
    call copy_string

    mov ecx, S2_len
    mov esi, S2
    mov edi, D_len
    add edi, D
    call copy_string

    mov byte [D + ecx], 0

    mov eax, 1       
    xor ebx, ebx     
    int 0x80         

copy_string:
    rep movsb       
    ret
