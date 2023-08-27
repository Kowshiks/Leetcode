class TicTacToe {

private:
    std::unordered_map<std::string, int[2]> cache;
    int n {0};

public:
    TicTacToe(int n) {

        this->n = n;

        for(int i{0} ; i < n; i++){

            cache['R' + std::to_string(i)][0] = 0;
            cache['R' + std::to_string(i)][1] = 0;

            cache['C' + std::to_string(i)][0] = 0;
            cache['C' + std::to_string(i)][1] = 0;

        }

        cache["D1"][0] = 0;
        cache["D1"][1] = 0;

        cache["D2"][0] = 0;
        cache["D2"][1] = 0;

    }
    
    int move(int row, int col, int player) {

        if (player == 1){

            cache['R'+std::to_string(row)][0] += 1;
            cache['C'+std::to_string(col)][0] += 1;

            if (row == col){

                cache["D1"][0] += 1;

            }

            if (row + col == n-1){

                cache["D2"][0] += 1;

            }

        }

        if (player == 2){

            cache['R'+std::to_string(row)][1] += 1;
            cache['C'+std::to_string(col)][1] += 1;

            if (row == col){

                cache["D1"][1] += 1;

            }

            if (row + col == n-1){

                cache["D2"][1] += 1;

            }

        }

        if ((cache['R'+std::to_string(row)][0] == n) || (cache['C'+std::to_string(col)][0] == n) || (cache["D1"][0] == n) || (cache["D2"][0] == n)) {

            return 1;
        }

        else if ((cache['R'+std::to_string(row)][1] == n) || (cache['C'+std::to_string(col)][1] == n) || (cache["D1"][1] == n) || (cache["D2"][1] == n)) {

            return 2;
        }

        return 0;
    }
};

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe* obj = new TicTacToe(n);
 * int param_1 = obj->move(row,col,player);
 */
