.MODEL SMALL
.DATA
    a DW 2 
    b DW 5
    c DW 8
    d DW 3
    result DW ?

.CODE
    MOV AX, @DATA
    MOV DS, AX

    MOV AX, a
    ADD AX, d
    MOV BX, AX 

    MOV AX, c
    SUB AX, BX 

    MOV BX, b
    ADD BX, d 

    ADD AX, BX 

    MOV result, AX

    MOV AH, 4CH
    INT 21H
END
