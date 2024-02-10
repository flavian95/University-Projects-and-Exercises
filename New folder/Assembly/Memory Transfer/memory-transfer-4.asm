.MODEL SMALL
.DATA
    memory_location1 DW 20H
    memory_location1 DW 40H

.CODE
    MOV AX, 1122h

    MOV BX, memory_location1
    MOV [BX], AL  

    MOV AX, 1122h

    MOV BX, memory_location2
    MOV [BX], AX

    MOV AH, 4CH
    INT 21H
END