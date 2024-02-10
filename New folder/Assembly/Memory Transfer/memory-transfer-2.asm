.MODEL SMALL
.DATA
    memory_location DW 0040h

.CODE
    MOV AL, 45h

    MOV BX, memory_location  
    MOV [BX], AL             

    MOV AH, 4CH
    INT 21H
END
