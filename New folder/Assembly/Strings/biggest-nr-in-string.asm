.MODEL SMALL
.STACK 100H
.DATA
    buffer    DB 100 DUP('$')              ; Buffer to store input string
    msg       DB 'Enter a string: $'
    resultMsg DB 'Largest character: $'
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

    ; Find the largest character in the string
                 LEA  SI, buffer+2          ; SI points to the actual string
                 CALL FIND_LARGEST

    ; Display the result
                 MOV  AH, 09H
                 LEA  DX, resultMsg
                 INT  21H

    ; Display the largest character
                 MOV  DL, [SI]              ; Load the largest character
                 MOV  AH, 02H
                 INT  21H

    ; Exit program
                 MOV  AH, 4CH
                 INT  21H

MAIN ENDP

FIND_LARGEST PROC
    ; Find the largest character in the string
                 MOV  AL, 0                 ; Initialize AL to 0
                 LEA  SI, buffer+2          ; SI points to the start of the string
    FIND_LOOP:   
                 MOV  BL, [SI]              ; Load the current character
                 CMP  BL, AL                ; Compare with the current largest character
                 JBE  SKIP_UPDATE           ; If BL <= AL, skip the update
                 MOV  AL, BL                ; Update the largest character

    SKIP_UPDATE: 
                 INC  SI                    ; Move to the next character
                 CMP  BYTE PTR [SI], '$'    ; Check for the end of the string
                 JNE  FIND_LOOP             ; If not end, continue the loop

                 RET
FIND_LARGEST ENDP

    END MAIN
