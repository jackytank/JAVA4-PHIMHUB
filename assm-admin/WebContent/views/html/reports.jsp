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
    <title>Report</title>
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
                            <li class="is-active" data-target="favorite">
                                <a>
                                    <span class="icon is-small"><i class="fas fa-photo-video"></i></span>
                                    <span>Favorite</span>
                                </a>
                            </li>
                            <li data-target="favorite-user">
                                <a>
                                    <span class="icon is-small"><i class="fas fa-list"></i></span>
                                    <span>Favorite Users</span>
                                </a>
                            </li>
                            <li data-target="shared-friend">
                                <a>
                                    <span class="icon is-small"><i class="fas fa-list"></i></span>
                                    <span>Shared Friends</span>
                                </a>
                            </li>
                        </ul>
                    </div>

                    <!-- tab content -->
                    <div class="px-2" id="tab-content">
                        <!-- favorite tab -->
                        <div id="favorite">
                            <table class="table is-bordered is-hoverable is-fullwidth">
                                <thead>
                                    <th>Video Title</th>
                                    <th>Favorite Count</th>
                                    <th>Latest Date</th>
                                    <th>Oldest Date</th>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>LÃ¢u GhÃª MÆ¡Ìi GÄÌ£p</td>
                                        <td>100</td>
                                        <td>31/12/2020</td>
                                        <td>01/01/2020</td>
                                    </tr>
                                    <tr>
                                        <td>LÃ¢u GhÃª MÆ¡Ìi GÄÌ£p</td>
                                        <td>100</td>
                                        <td>31/12/2020</td>
                                        <td>01/01/2020</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <!-- favorite user tab -->
                        <div id="favorite-user" class="is-hidden">
                            <form action="" method="post">
                                <div class="field is-horizontal">
                                    <div class="field-label is-normal">
                                        <label class="label">Video Title</label>
                                    </div>
                                    <div class="field-body">
                                        <div class="field">
                                            <div class="control">
                                                <div class="select is-fullwidth">
                                                    <select>
                                                        <option>Select dropdown</option>
                                                        <option>With options</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="field">
                                    <table class="table is-bordered is-hoverable is-fullwidth">
                                        <thead>
                                            <th>Username</th>
                                            <th>Fullname</th>
                                            <th>Email</th>
                                            <th>Favorite Date</th>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>TeoNV</td>
                                                <td>NguyÃªÌn VÄn TeÌo</td>
                                                <td>teonv@gmail.com</td>
                                                <td>01/01/2020</td>
                                            </tr>
                                            <tr>
                                                <td>TeoNV</td>
                                                <td>NguyÃªÌn VÄn TeÌo</td>
                                                <td>teonv@gmail.com</td>
                                                <td>01/01/2020</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </form>
                        </div>

                        <!-- shared friend tab -->
                        <div id="shared-friend" class="is-hidden">
                            <form action="" method="post">
                                <div class="field is-horizontal">
                                    <div class="field-label is-normal">
                                        <label class="label">Video Title</label>
                                    </div>
                                    <div class="field-body">
                                        <div class="field">
                                            <div class="control">
                                                <div class="select is-fullwidth">
                                                    <select>
                                                        <option>Select dropdown</option>
                                                        <option>With options</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="field">
                                    <table class="table is-bordered is-hoverable is-fullwidth">
                                        <thead>
                                            <th>Sender Name</th>
                                            <th>Sender Email</th>
                                            <th>Receiver Email</th>
                                            <th>Sent Date</th>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>NguyÃªÌn VÄn TeÌo</td>
                                                <td>teonv@gmail.com</td>
                                                <td>poly@gmail.com</td>
                                                <td>01/01/2020</td>
                                            </tr>
                                            <tr>
                                                <td>NguyÃªÌn VÄn TeÌo</td>
                                                <td>teonv@gmail.com</td>
                                                <td>poly@gmail.com</td>
                                                <td>01/01/2020</td>
                                            </tr>
                                        </tbody>
                                    </table>
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