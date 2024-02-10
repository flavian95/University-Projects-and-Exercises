.model small
.data
    string1 db "Hello, ", 0
    string2 db "Assembly!", 0

.code
main proc
         mov ax, @data
         mov ds, ax

         lea dx, string1
         mov ah, 9
         int 21h

         mov ah, 2
         mov dl, 0DH
         int 21h
         mov dl, 0AH
         int 21h

         lea dx, string2
         mov ah, 9
         int 21h

         mov ax, 4C00h
         int 21h
main endp

end main
