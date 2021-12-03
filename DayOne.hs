module DayOne where 
import System.IO

increased :: [Int] -> Int 
increased (x:y:rest) 
    | x < y     = 1 + increased (y:rest) 
    | otherwise =     increased (y:rest)
increased _ = 0

classed :: [Int] -> [Int] 
classed (x:y:z:rest) = (x+y+z) : classed (y:z:rest)
classed _ = []

main :: IO ()
main = do 
    handle <- openFile "DayOne.txt" ReadMode 
    contents <- hGetContents handle 
    let part1 = (increased 
                .map read
                .words) contents
    -- print part1
    let part2 = (increased 
                .classed 
                .map read 
                .words) contents
    print part2