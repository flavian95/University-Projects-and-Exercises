.MODEL SMALL
.DATA
    memory_location DW 40h  
    
.CODE
    MOV AX, 46AEh               

    MOV BX, memory_location  
    MOV [BX], AX             

    MOV AL, 45h 
    MOV BX, memory_location  
    ADD AL, BX
                     
    MOV AH, 4CH
    INT 21H
END