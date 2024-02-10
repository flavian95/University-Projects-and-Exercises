section .data
    buffer db 1         
    msg db 'Enter a character: $'  

section .text
    mov ah, 09           
    lea dx, msg          
    int 21h              

    mov ah, 01           
    int 21h             
    mov [buffer], al     

    mov ah, 02           
    mov dl, [buffer]     
    int 21h             

    mov ah, 4Ch          
    int 21h              