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
    <title>Login</title>
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
                            <li class="is-active" data-target="video-edition">
                                <a>
                                    <span class="icon is-small"><i class="fas fa-photo-video"></i></span>
                                    <span>VIDEO EDITION</span>
                                </a>
                            </li>
                            <li data-target="video-list">
                                <a>
                                    <span class="icon is-small"><i class="fas fa-list"></i></span>
                                    <span>VIDEO LIST</span>
                                </a>
                            </li>
                        </ul>
                    </div>

                    <!-- tab content -->
                    <div class="px-2" id="tab-content">
                        <!-- video edition tab -->
                        <div id="video-edition">
                            <form action="" method="post">
                                <div class="columns">
                                    <div class="column is-5 is-flex is-align-items-center">
                                        <figure class="image">
                                            <img src="https://img.youtube.com/vi/k22bXacrGtE/0.jpg" alt="" width="256"
                                                height="256">
                                        </figure>
                                    </div>
                                    <div class="column">
                                        <div class="field">
                                            <label class="label">Youtube ID</label>
                                            <div class="control">
                                                <input class="input" type="text">
                                            </div>
                                        </div>
                                        <div class="field">
                                            <label class="label">Video Title</label>
                                            <div class="control">
                                                <input class="input" type="text">
                                            </div>
                                        </div>
                                        <div class="field">
                                            <label class="label">View Count</label>
                                            <div class="control">
                                                <input class="input" type="number">
                                            </div>
                                        </div>
                                        <div class="field">
                                            <div class="control">
                                                <label class="radio">
                                                    <input type="radio" name="answer">
                                                    Active
                                                </label>
                                                <label class="radio">
                                                    <input type="radio" name="answer">
                                                    In-active
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="field">
                                    <label class="label">Description</label>
                                    <div class="control">
                                        <textarea class="textarea"></textarea>
                                    </div>
                                </div>
                                <hr>
                                <div class="field is-grouped is-grouped-right">
                                    <div class="control">
                                        <button class="button is-light">Create</button>
                                    </div>
                                    <div class="control">
                                        <button class="button is-light">Update</button>
                                    </div>
                                    <div class="control">
                                        <button class="button is-light ">Delete</button>
                                    </div>
                                    <div class="control">
                                        <button class="button is-light ">Reset</button>
                                    </div>
                                </div>
                            </form>
                        </div>

                        <!-- video list tab -->
                        <div id="video-list" class="is-hidden">
                            <form action="" method="post">
                                <table class="table is-bordered is-hoverable is-fullwidth">
                                    <thead>
                                        <th>Youtube ID</th>
                                        <th>Video Title</th>
                                        <th>View Count</th>
                                        <th>Status</th>
                                        <th></th>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1JsndSd</td>
                                            <td>Baby Shark</td>
                                            <td>3456234</td>
                                            <td>Active</td>
                                            <td><a href="">Edit</a></td>
                                        </tr>
                                        <tr>
                                            <td>1JsndSd</td>
                                            <td>Baby Shark</td>
                                            <td>3456234</td>
                                            <td>Active</td>
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