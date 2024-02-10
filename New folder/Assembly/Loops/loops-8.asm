.model small
.data
    buffer         dw 10 dup(?)
    memoryLocation dw ?
.code
main proc
              mov  cx, 20
              lea  di, buffer
              mov  ax, 10h

    fill_loop:
              mov  [di], ax
              add  ax, 10
              add  di, 2
              loop fill_loop

              mov  ah, 4Ch
              int  21h
main endp

end main