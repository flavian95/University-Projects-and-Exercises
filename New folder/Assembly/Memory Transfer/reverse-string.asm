.MODEL SMALL
.DATA
    myString DB 01H, 02H, 03H, 04H, 05H, 06H, 07H, 08H, 09H, 0AH 

.CODE
    MOV AX, @DATA   
    MOV DS, AX

    MOV DX, OFFSET myString
    MOV AH, 09H       
    INT 21H            

    MOV SI, 0         
    MOV DI, 9          

reverseLoop:
    CMP SI, DI
    JAE endReverse   

    MOV AL, myString[SI]
    MOV BH, myString[DI]
    MOV myString[SI], BH
    MOV myString[DI], AL

    INC SI
    DEC DI
    JMP reverseLoop

endReverse:

    MOV DX, OFFSET myString
    MOV AH, 09H         
    INT 21H           

    MOV AH, 4CH       
    INT 21H          
END
