section .data
    S dd 2, 7, 10, 15, 24, 31, 42, 53    
    len equ $ - S                        

    D1 resd len                         
    D2 resd len                        

section .text
    global _start

_start:
    mov ecx, len                        
    mov esi, S                          
    mov edi, D1                         
    mov edx, D2                         

    construct_D:
        mov eax, [esi]                  
        test eax, 1                     
        jnz odd_value                   

        mov [edi], eax                  
        add edi, 4                      
        jmp next_value                  

    odd_value:
        mov [edx], eax                 
        add edx, 4                     

    next_value:
        add esi, 4                     
        loop construct_D                

    mov eax, 1                          
    xor ebx, ebx                        
    int 0x80                            
