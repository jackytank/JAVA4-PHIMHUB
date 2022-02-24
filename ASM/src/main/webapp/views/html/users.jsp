<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
        integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <title>Edit User</title>
    <link rel="icon" href="https://tinyzonetv.to/images/group_2/theme_1/logo.png?v=0.1" type="image/x-icon">
    <script src="../js/components/footer.js" defer></script>
    <script src="../js/components/header.js" defer></script>
    <script src="../js/script.js" defer></script>
</head>

<body>
    <header-component></header-component>

    <section class="hero is-fullheight">
        <div class="columns is-centered mt-4">
            <div class="column is-6">
                <div class="box">
                    <!-- tab header -->
                    <div class="tabs is-boxed">
                        <ul>
                            <li class="is-active" data-target="user-edition">
                                <a>
                                    <span class="icon is-small"><i class="fas fa-user-alt"></i></span>
                                    <span>USER EDITION</span>
                                </a>
                            </li>
                            <li data-target="user-list">
                                <a>
                                    <span class="icon is-small"><i class="fas fa-list"></i></span>
                                    <span>USER LIST</span>
                                </a>
                            </li>
                        </ul>
                    </div>

                    <!-- tab content -->
                    <div class="px-2" id="tab-content">
                        <!-- user edition tab -->
                        <div id="user-edition">
                            <form action="" method="post">
                                <div class="field is-horizontal">
                                    <div class="field-body">
                                        <div class="field">
                                            <div class="control">
                                                <label  class="label">Username</label>
                                                <input type="text" class="input">
                                            </div>
                                        </div>
                                        <div class="field">
                                            <div class="control">
                                                <label  class="label">Password</label>
                                                <input type="password" class="input">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="field is-horizontal">
                                    <div class="field-body">
                                        <div class="field">
                                            <div class="control">
                                                <label  class="label">Fullname</label>
                                                <input type="text" class="input">
                                            </div>
                                        </div>
                                        <div class="field">
                                            <div class="control">
                                                <label  class="label">Email</label>
                                                <input type="email" class="input">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <hr>
                                <div class="field is-grouped is-grouped-right">
                                    <div class="control">
                                        <button class="button is-light" type="submit">Update</button>
                                    </div>
                                    <div class="control">
                                        <button class="button is-light" type="submit">Delete</button>
                                    </div>
                                </div>
                            </form>
                        </div>

                        <!-- user list tab -->
                        <div id="user-list" class="is-hidden">
                            <form action="" method="post">
                                <table class="table is-bordered is-hoverable is-fullwidth">
                                    <thead>
                                        <th>Username</th>
                                        <th>Password</th>
                                        <th>Fullname</th>
                                        <th>Email</th>
                                        <th>Role</th>
                                        <th></th>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>TeoNV</td>
                                            <td>123456</td>
                                            <td>Nguyễn Văn Tèo</td>
                                            <td>teonv@gmail.com</td>
                                            <td>Admin</td>
                                            <td><a href="">Edit</a></td>
                                        </tr>
                                        <tr>
                                            <td>TeoNV</td>
                                            <td>123456</td>
                                            <td>Nguyễn Văn Tèo</td>
                                            <td>teonv@gmail.com</td>
                                            <td>Admin</td>
                                            <td><a href="">Edit</a></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="field is-grouped is-grouped-centered">
                                    <div class="control">
                                        <button class="button" type="button">
                                            <span class="icon">
                                                <i class="fas fa-angle-double-left"></i>
                                            </span>
                                        </button>
                                    </div>
                                    <div class="control">
                                        <button class="button" type="button">
                                            <span class="icon">
                                                <i class="fas fa-chevron-left"></i>
                                            </span>
                                        </button>
                                    </div>
                                    <div class="control">
                                        <button class="button" type="button">
                                            <span class="icon">
                                                <i class="fas fa-chevron-right"></i>
                                            </span>
                                        </button>
                                    </div>
                                    <div class="control">
                                        <button class="button" type="button">
                                            <span class="icon">
                                                <i class="fas fa-angle-double-right"></i>
                                            </span>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <footer-component></footer-component>
</body>

</html>