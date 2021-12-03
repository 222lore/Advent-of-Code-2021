module DayTwo where
import System.IO
import Data.Char

combineList :: [String] -> [String]
combineList (x:y:rest) = (x++y) : combineList rest
combineList _ = []

-- (Forward, Depth)
movements :: [String] -> Int
movements xs = aux xs 0 0 where -- aux list forward depth
    aux :: [String] -> Int -> Int -> Int
    aux (x:xs) forward depth
        | head x == 'f' = let newForward = forward + readLine x
                          in aux xs newForward depth
        | head x == 'd' = let newDepth = depth + readLine x
                          in aux xs forward newDepth
        | otherwise     = let newDepth = depth - readLine x 
                          in aux xs forward newDepth 
    aux [] forward depth = forward * depth

readLine :: String -> Int 
readLine str = read (dropWhile (\c -> isSpace c || isLetter c) str)

movements' :: [String] -> Int 
movements' xs = aux xs 0 0 0 where -- aux list forward depth aim 
    aux :: [String] -> Int -> Int -> Int -> Int 
    aux (x:xs) forward depth aim 
        | head x == 'f' = let newForward = forward + readLine x
                              newDepth = depth + aim * readLine x
                          in aux xs newForward newDepth aim
        | head x == 'd' = let newAim = aim + readLine x
                          in aux xs forward depth newAim
        | otherwise     = let newAim = aim - readLine x 
                          in aux xs forward depth newAim 
    aux [] forward depth aim = forward * depth

main :: IO ()
main = do
    handle <- openFile "DayTwo.txt" ReadMode
    contents <- hGetContents handle
    let part1 = (movements 
                .combineList 
                .words) contents
    --print part1
    let part2 = (movements' 
                .combineList 
                .words) contents
    print part2