.model small
.data
    S1   db  1, 3, 5, 7
    S2   db  2, 6, 9, 4
    D    db  0, 0, 0, 0, 0, 0, 0, 0
    len  equ 4

.code
main proc
                    mov ax, @data
                    mov ds, ax

                    lea si, S1
                    lea di, S2
                    lea bx, D

                    xor cx, cx

    interleave_loop:
                    mov al, [si]
                    mov [bx], al
                    inc bx

                    mov al, [di]
                    mov [bx], al
                    inc bx

                    inc si
                    inc di

                    inc cx
                    cmp cx, len
                    jl  interleave_loop

                    lea dx, D
                    mov ah, 9
                    int 21h

                    mov ax, 4C00h
                    int 21h
main endp
end main
