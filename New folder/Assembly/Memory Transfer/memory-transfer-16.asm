.MODEL small
.STACK 100h

.DATA
    memoryAddress1 DB ?
    memoryAddress2 DB ?

.CODE
main PROC
         mov ax, @data
         mov ds, ax

         mov ax, 2233h
         mov cx, 99aah
         mov dl, 20h
         mov bx, 20h

         add bx, dl
         add ax, cx

         mov [memoryAddress1], bx

         sub bx, dl
         sub ax, cx
         mov [memoryAddress2], bx
        
         mov AH, 4Ch
         int 21h

main ENDP
END main