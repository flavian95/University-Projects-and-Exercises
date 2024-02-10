.MODEL small
.STACK 100h

.DATA
    memory_area DB 20 DUP(?)
    result      DW ?

.CODE
main PROC
              mov  SI, OFFSET memory_area
              mov  CX, 20

              mov  AL, 5h

    fill_loop:
              mov  [SI], AL
              add  result, AX
              inc  SI
              loop fill_loop

              mov  SI, OFFSET result
              mov  [SI], AX

              mov  AH, 4Ch
              int  21h

main ENDP
END main