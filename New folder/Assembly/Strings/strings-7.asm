.model small
.data
    S1   db  1, 3, 6, 2, 3, 7
    S2   db  6, 3, 8, 1, 2, 5
    D    db  0, 0, 0, 0, 0, 0, 0, 0
    len  equ 6

.code
main proc
                     mov ax, @data
                     mov ds, ax

                     lea si, S1
                     lea di, S2
                     lea bx, D

                     xor cx, cx

    max_element_loop:
                     mov al, [si]
                     cmp al, [di]
                     jg  store_max

                     mov al, [di]
    store_max:       
                     mov [bx], al
                     inc bx

                     inc si
                     inc di

                     inc cx
                     cmp cx, len
                     jl  max_element_loop

                     lea dx, D
                     mov ah, 9
                     int 21h

                     mov ax, 4C00h
                     int 21h
main endp
end main
