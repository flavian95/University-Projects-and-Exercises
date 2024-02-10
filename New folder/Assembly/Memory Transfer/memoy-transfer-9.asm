section .data

section .text
global _start

_start:
    mov  AL, 15     
    mov  BX, 12    
    mov  CL, 44      
    mov  DL, 56     

    mov  SI, BX      
    mov  [SI], 0B9h  

    add  AL, CL      
    add  AL, DL  

    mov si, BX
    sub [si], AL

    mov  SI, BX      
    inc  SI          
   sub  [SI], AL    


    mov  eax, 1       
    xor  ebx, ebx     
    int  0x80         
