.MODEL small
.STACK 100h

.DATA
    a      dw b9h
    result dw ?

.CODE
main PROC
         mov ax, @data
         mov ds, ax

         mov al, 15h
         mov bx, 12h
         mov cl, 44h
         mov dl, 56h

         mov [a], bx

         mov al, cl
         mov al, dl

         sub word ptr [a], ax

         mov ax, [a]
         mov [result], al


         mov AH, 4Ch
         int 21h

main ENDP
END main