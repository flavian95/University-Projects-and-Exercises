.MODEL SMALL
.DATA
    memory_location1 DW 20H
    memory_location1 DW 40H

.CODE
    MOV AL, 45h

    MOV BX, memory_location1
    MOV [BX], AL  

    MOV BX, memory_location2
    MOV [BX], AL     

    PUSH AL

    MOV AH, 4CH
    INT 21H
END