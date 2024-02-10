section .data
    buffer db 5           
    msg db 'Enter a number: $' 
    even_msg db 'The number is even.$'
    odd_msg db 'The number is odd.$'

section .text
    mov ah, 09           
    lea dx, msg          
    int 21h              

    mov ah, 0Ah          
    lea dx, buffer       
    int 21h             

    mov al, [buffer + 2] 
    sub al, '0'        
    mov bl, 10           

    mov ah, 0           
convert_loop:
    imul ax, bl          
    add al, [buffer + bx]
    sub al, '0'          
    inc bl               
    cmp bl, 6            
    jl convert_loop      

    test al, 1           
    jz  even_number      
    jmp odd_number       

even_number:
    mov ah, 09           
    lea dx, even_msg     
    int 21h              
    jmp exit_program     

odd_number:
    mov ah, 09           
    lea dx, odd_msg      
    int 21h              

exit_program:
    mov ah, 4Ch         
    int 21h             
