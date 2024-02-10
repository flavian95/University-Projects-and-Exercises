.model small
.data
    buffer  db 255 dup(?)
    newline db 0DH, 0AH, '$'

.code
main proc
                mov ax, @data
                mov ds, ax

    input_loop: 
                mov ah, 1
                int 21h

                cmp al, 0DH
                je  end_program

                mov ah, 2
                mov dl, al
                int 21h

                jmp input_loop

    end_program:
                lea dx, newline
                mov ah, 9
                int 21h

                mov ax, 4C00h
                int 21h
main endp

end main
