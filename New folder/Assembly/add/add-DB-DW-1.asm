.MODEL SMALL
.DATA
    byteValue DB 11H
    wordValue DW 3344H
    result DW ?

.CODE
    MOV AX, @DATA      
    MOV DS, AX

    MOV AX, byteValue   
    CBW                 
    ADD AX, wordValue   

    MOV result, AX         

    MOV AH, 4CH        
    INT 21H            
END