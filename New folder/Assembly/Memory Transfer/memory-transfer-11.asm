.MODEL small
.STACK 100h

.DATA
    memoryAddress1 DW 20h
    memoryAddress2 DW 20h
    loadMemory     DW 45h

.CODE
main PROC
         mov  al, @data
         mov  ds, al

         mov  al, [loadMemory]
         mov  [memoryAddress1], al
        
         mov  al, [loadMemory]
         mov  [memoryAddress2], al

         push al
       
         mov  AH, 4Ch
         int  21h

main ENDP
END main