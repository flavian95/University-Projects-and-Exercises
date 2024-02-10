.MODEL small
.STACK 100h

.DATA
    a      db 22h
    b      db 11h
    c      db 33h
    d      db 44h
    result db ?

.CODE
main PROC
         mov  ax, @data
         mov  ds, ax

         mov  al, c
         add  al, 192
         sub  al, b

         mov  bl, d
         mov  dl, a
         imul dl

         add  al, bl
 
         mov  [result], al
         
         mov  al, 4Ch
         int  21h

main ENDP
END main