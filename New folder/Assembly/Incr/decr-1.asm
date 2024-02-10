section .data

section .text
global _start

_start:
    mov  AL, 5       
    mov  BL, 16      
    mov  CL, 59      

    dec  AL           
    dec  BL           
    dec  CL           

    mov  eax, 1       
    xor  ebx, ebx     
    int  0x80         

