.MODEL SMALL
.DATA
    A DB 11H
    B DB 22H
    C DW 3344H
    D DW 5566H
    result DW ?

.CODE
    MOV AX, @DATA      
    MOV DS, AX

    MOV AX, A
    MOV BX, B
    ADD AX, BX
    CBW

    MOV BX, C 
    ADD BX, D

    SUB AX, BX

    MOV result, AX         

    MOV AH, 4CH        
    INT 21H            
END