.MODEL small
.STACK 100h

.DATA
    memoryAddress1 DW 40h
    loadMemory1    DW 46aeH
    loadMemory2    DW 45h
.CODE
main PROC
         mov ax, @data
         mov ds, ax

         mov ax, [loadMemory1]
         mov [memoryAddress1], ax
        
         mov al, [loadMemory2]
         add ax, [loadMemory2]
        
        
       
         mov AH, 4Ch
         int 21h

main ENDP
END main