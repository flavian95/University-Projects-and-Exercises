.MODEL small
.STACK 100h

.DATA
    a    DB 11H
    b    DB 22H
    c    DW 3344H
    d    DW 5566H
.CODE
main PROC
         mov ax, @data
         mov ds, ax

         mov ax, c
         add ax, d

         mov bx, a
         add bx, b
         cbw

         sub ax, bx
                
         mov ax, 4Ch
         int 21h

main ENDP
END main