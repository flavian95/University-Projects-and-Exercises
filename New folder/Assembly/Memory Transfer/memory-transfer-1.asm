.MODEL SMALL
.DATA
    memory_location DW 40h  
    constant_value  DW 3446h
    
.CODE
    MOV AX, constant_value   
    MOV DS, AX              

    MOV BX, memory_location  
    MOV [BX], AX             

    MOV AH, 9                
    LEA DX, [memory_location] 
    INT 21H                  

    MOV AH, 4CH
    INT 21H
END