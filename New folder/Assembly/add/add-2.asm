.MODEL SMALL
.DATA
    Memory_Address DW ?
    Result_Sum DW ?
    Result_Difference DW ?

.CODE
    MOV AX, 2233H  
    MOV CX, 99AAH  
    MOV DL, 20H 
    MOV BX, 20H

    ADD AX, CX
    ADD CX, BX

    MOV Memory_Address, CX
    MOV Result_Sum, AX

    MOV CX, Memory_Address
    INC CX             
    SUB CX, BX          

    MOV Result_Difference, CX

    MOV AH, 4CH         
    INT 21H           
END

