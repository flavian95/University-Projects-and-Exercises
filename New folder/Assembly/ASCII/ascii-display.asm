.model small
.data
    lower_limit equ 30h
    upper_limit equ 80h
    newline     db  0DH, 0AH, '$'
    
.code
main proc
                 mov ax, @data
                 mov ds, ax

                 mov bl, lower_limit
                 mov cx, upper_limit - lower_limit + 1

    display_loop:
                 mov ah, 2
                 mov dl, bl
                 int 21h

                 cmp bl, upper_limit
                 je  end_program

                 mov ah, 2
                 mov dl, ' '
                 int 21h

                 inc bl

                 jmp display_loop

    end_program: 
                 lea dx, newline
                 mov ah, 9
                 int 21h

                 mov ax, 4C00h
                 int 21h
main endp

end main
