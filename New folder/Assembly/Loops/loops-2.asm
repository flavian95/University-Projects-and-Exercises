.MODEL small
.STACK 100h

.DATA
    memory_area DB 20 DUP(?)

.CODE
main PROC
              mov  SI, OFFSET memory_area
              mov  CX, 20

              mov  AL, 33h

    fill_loop:
              mov  [SI], AL
              inc  SI
              loop fill_loop

              mov  AH, 4Ch
              int  21h

main ENDP
END main

