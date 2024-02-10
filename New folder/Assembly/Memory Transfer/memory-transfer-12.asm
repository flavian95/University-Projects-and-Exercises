.MODEL small
.STACK 100h

.DATA
    memoryAddress1 DW 20h
    memoryAddress2 DW 40h
    loadMemory1    DW 1122h
    loadMemory2    DW 44h
.CODE
main PROC
         mov al, @data
         mov ds, al

         mov al, [loadMemory1]
         mov [memoryAddress1], al
        
         mov al, [loadMemory2]
         mov [memoryAddress2], al
        
       
         mov AH, 4Ch
         int 21h

main ENDP
END main