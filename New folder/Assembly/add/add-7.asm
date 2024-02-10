.MODEL small
.STACK 100h

.DATA
    a      dw 22h
    b      dw 11h
    c      dw 33h
    d      dw 44h
    result dw ?

.CODE
main PROC
         mov  ax, @data
         mov  ds, ax

         mov  ax, b
         add  ax, 128

         mov  bx, a
         mov  dx, d
         imul dx
         add  dx, c

         sub  ax, dx
         
         mov  [result], ax
         
         mov  ax, 4Ch
         int  21h

main ENDP
END main