section .data

section .text
global _start

_start:
    mov  si, 10      

load_values:
    mov  al, 01h     
    mov  [si], al   
    inc  al          
    inc  si          
    loop load_values

    mov  eax, 1      
    xor  ebx, ebx     
    int  0x80         
