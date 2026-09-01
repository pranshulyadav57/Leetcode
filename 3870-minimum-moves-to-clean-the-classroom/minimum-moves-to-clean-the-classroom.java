class Solution {
    int n;
    int m;
    int c;
    int[][] litter;

    public int minMoves(String[] classroom, int energy) {

        int sx = -1;
        int sy = -1;
        int tL = 0;

        n = classroom.length;
        m = classroom[0].length();
        c = energy;

        litter = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(litter[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (classroom[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                }

                if (classroom[i].charAt(j) == 'L') {
                    litter[i][j] = tL++;
                }
            }
        }

        int masks = 1 << tL;
        int target = masks - 1;

        int[][][] best = new int[n][m][masks];

        for (int[][] layer : best) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        class State {
            int x, y, mask, e, moves;

            State(int x, int y, int mask, int e, int moves) {
                this.x = x;
                this.y = y;
                this.mask = mask;
                this.e = e;
                this.moves = moves;
            }
        }

        Queue<State> q = new LinkedList<>();

        q.add(new State(sx, sy, 0, c, 0));
        best[sx][sy][0] = c;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            State cur = q.poll();

            int x = cur.x;
            int y = cur.y;
            int mask = cur.mask;
            int e = cur.e;
            int moves = cur.moves;

            if (mask == target) {
                return moves;
            }

            if (e == 0) {
                continue;
            }

            for (int d = 0; d < 4; d++) {

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (classroom[nx].charAt(ny) == 'X') {
                    continue;
                }

                int ne = e - 1;
                int nmask = mask;

                if (classroom[nx].charAt(ny) == 'L') {
                    nmask |= (1 << litter[nx][ny]);
                }

                if (classroom[nx].charAt(ny) == 'R') {
                    ne = c;
                }

                if (best[nx][ny][nmask] >= ne) {
                    continue;
                }

                best[nx][ny][nmask] = ne;

                q.add(new State(nx, ny, nmask, ne, moves + 1));
            }
        }

        return -1;
    }
}