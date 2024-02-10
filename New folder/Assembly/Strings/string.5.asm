   section .data
    input_string db 'YourInputStringHere', 0    
    output_string db 255 dup(0)                 

section .text
    global _start

_start:
    mov esi, input_string   
    mov edi, output_string  
    xor ecx, ecx           
    xor edx, edx            

process_next_byte:
    mov al, [esi]           

    test ecx, 1             
    jnz even_position       

    mov [edi + edx], al   
    inc edx                 
    jmp next_iteration      

even_position:
    mov esi, input_string   
    add esi, ecx            
    mov al, [esi]           

    mov ebx, edi            
    add ebx, edx            
    mov [ebx], al           
    inc ecx                 

next_iteration:
    inc esi                 
    test byte [esi], 0      
    jnz process_next_byte   

    mov byte [edi + edx], 0

    mov eax, 1            
    xor ebx, ebx            
    int 0x80                

      
