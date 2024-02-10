.MODEL small
.STACK 100h

.DATA
    

.CODE
main PROC
         mov  ax, @data
         mov  ds, ax

         mov  al, 5
         mov  bl, 16
         mov  cl, 59

         dec  al
         dec  bl
         dec  cl

         imul al, bl
         imul al, cl

         mov  AH, 4Ch
         int  21h

main ENDP
END main