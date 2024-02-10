.MODEL small
.STACK 100h

.DATA
    a      DW 11H
    b      DW 22H
    result DW ?
.CODE
main PROC
         mov ax, @data
         mov ds, ax

         mov ax, a
         add ax, b
         mov [result], ax
           
         mov ax, 4Ch
         int 21h

main ENDP
END main