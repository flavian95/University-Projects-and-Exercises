section .data
    buffer db 1         
    msg db 'Enter a character (press Enter to exit): $'  

section .text
    mov ah, 09           
    lea dx, msg          
    int 21h              

read_character:
    mov ah, 01           
    int 21h              
    cmp al, 0Dh          
    je  exit_program    

    cmp al, 'a'
    jb  print_character   
    cmp al, 'z'
    ja  print_character   

    sub al, 32

print_character:
    mov ah, 02           
    int 21h              
    jmp read_character   

exit_program:
    mov ah, 4Ch          
    int 21h              
