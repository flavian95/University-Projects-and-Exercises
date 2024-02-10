.MODEL small
.STACK 100h

.DATA
    startAddress  DW 10h
    currentValue  DB 01h
    numIterations DB 4

.CODE
main PROC
             mov  ax, @data
             mov  ds, ax

             mov  cx, numIterations

             mov  si, startAddress

    loadLoop:
             mov  [si], currentValue

             inc  si
             inc  currentValue

             loop loadLoop

             mov  AH, 4Ch
             int  21h

main ENDP
END main
