.MODEL small
.STACK 100h

.DATA
    memory_area DB 20 DUP(?)

.CODE
main PROC
              mov  SI, OFFSET memory_area
              mov  CX, 20

              mov  AL, 200h

    fill_loop:
              mov  [SI], AL
              sub  AL, 10h

              cmp  AL, 10h
              jle  end_loop

              inc  SI
              loop fill_loop

    end_loop: 

              mov  AH, 4Ch
              int  21h

main ENDP
END main