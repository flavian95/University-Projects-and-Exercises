.MODEL SMALL
.DATA
    memory_location_1 DW ?
    memory_location_2 DW ?

.CODE
    MOV AX, 2233h
    MOV CX, 99AAh
    MOV DL, 20h
    MOV BX, 20h

    ADD AX, CX

    MOV SI, BX
    ADD SI, DL

    MOV [SI], AX

    MOV DI, SI
    SUB DI, DL

    MOV [DI], CX

    MOV AH, 4CH
    INT 21H
END
