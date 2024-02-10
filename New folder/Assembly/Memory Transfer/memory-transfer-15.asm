.MODEL small
.STACK 100h

.DATA
    memoryAddress DW 20h
    loadMemory1   DW 67H
    loadMemory2   DW 0EAH
.CODE
main PROC
         mov ax, @data
         mov ds, ax

         mov ax, [loadMemory1]
         mov bx, [loadMemory2]

         add ax, bx
         mov [memoryAddress], ax
        
         mov AH, 4Ch
         int 21h

main ENDP
END main