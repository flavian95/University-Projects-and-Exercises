.MODEL small
.STACK 100h

.DATA
    memoryAddress DW 40h
    loadMemory    DW 45h

.CODE
main PROC
         mov ax, @data
         mov ds, ax

         mov ax, [loadMemory]
         mov [memoryAddress], ax
       
         mov AH, 4Ch
         int 21h

main ENDP
END main