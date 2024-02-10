.MODEL SMALL
.DATA
    memory_location DW 20h  
    
.CODE
    MOV AX, 67H

    MOV BX, 234H
    ADD AX, BX

    MOV BX, memory_location
    MOV [BX], AX
                     
    MOV AH, 4CH
    INT 21H
END