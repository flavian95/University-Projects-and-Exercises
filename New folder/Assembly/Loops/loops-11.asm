.model small
.data
    buffer dw 10 dup(?)
.code
main proc
              mov  cx, 50
              lea  di, buffer
              mov  ax, 5h

    fill_loop:
              mov  [di], ax
              inc  ax, 5
              inc  di
              loop fill_loop

              mov  ah, 4Ch
              int  21h
main endp

end main