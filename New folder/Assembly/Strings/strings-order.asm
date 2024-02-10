.MODEL SMALL
.STACK 100H
.DATA
    buffer    DB 100 DUP('$')              ; Buffer to store input string
    msg       DB 'Enter a string: $'
    sortedMsg DB 'Sorted characters: $'
    crlf      DB 0DH, 0AH, '$'             ; Carriage return and line feed

.CODE
MAIN PROC
                MOV  AX, @DATA             ; Initialize DS register
                MOV  DS, AX

    ; Display message to enter a string
                MOV  AH, 09H
                LEA  DX, msg
                INT  21H

    ; Read a string from the keyboard
                MOV  AH, 0AH
                LEA  DX, buffer
                INT  21H

    ; Sort the characters in the string
                LEA  SI, buffer+2          ; SI points to the actual string
                CALL SORT_STRING

    ; Display the sorted characters
                MOV  AH, 09H
                LEA  DX, sortedMsg
                INT  21H

    ; Display the sorted string
                LEA  DX, buffer+2
                INT  21H

    ; Exit program
                MOV  AH, 4CH
                INT  21H

MAIN ENDP

SORT_STRING PROC
    ; Sort characters in the string using bubble sort
                MOV  CX, 0                 ; Flag to check if any swaps were made
    OUTER_LOOP: 
                MOV  SI, buffer+2          ; SI points to the start of the string
                MOV  BX, SI                ; BX also points to the start of the string
                INC  BX                    ; Point BX to the next character
                MOV  CX, 0                 ; Reset the swap flag
    INNER_LOOP: 
                MOV  AL, [SI]              ; Load the current character
                CMP  AL, [BX]              ; Compare with the next character
                JBE  SKIP_SWAP             ; If AL <= [BX], no swap needed

    ; Swap characters
                MOV  DL, [SI]
                MOV  [SI], [BX]
                MOV  [BX], DL

    ; Set the swap flag
                MOV  CX, 1

    SKIP_SWAP:  
                INC  SI                    ; Move to the next character
                INC  BX                    ; Move to the next character
                CMP  BYTE PTR [SI], '$'    ; Check for the end of the string
                JNE  INNER_LOOP            ; If not end, continue the inner loop
                TEST CX, CX                ; Check if any swaps were made
                JNZ  OUTER_LOOP            ; If swaps made, repeat the outer loop

                RET
SORT_STRING ENDP

    END MAIN
